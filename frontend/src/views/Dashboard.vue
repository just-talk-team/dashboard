<template>
  <v-container>
    <br><h1 class="text-center">Just Talk Dashboard</h1><br>

<div class="event-listing">
    <div class="search-row">

      <div class="field">
        <label>Fecha Inicio:</label>
        <input type="date" name="startDate" v-model="startDate" />
      </div>
      <div class="field">
        <label>Fecha Fin:</label>
        <input type="date" name="endDate" v-model="endDate"  />
      </div>

      <div class="field">
        <label>Tipo de Usuario:</label>
        <select
          :v-model="userType"
          name="userType">
          <option name="userType" value="everyone" selected>Todos</option>
          <option name="userType" value="free">Freemium</option>
          <option name="userType" value="premium">Premium</option>
        </select>
      </div>

      <div class="field">
        <label>Género:</label>
        <select
          :v-model="gender"
          name="gender">
          <option name="gender" value="both" selected>Ambos</option>
          <option name="gender" value="femenine">F</option>
          <option name="gender" value="">M</option>
        </select>
      </div>

      <div class="field">
        <label>Edad:</label>
				<v-text-field 
					label="Desde" 
					type= "text"
          pattern="[0-99]" maxlength="2"
					:v-model="age1"/>
				<v-text-field
					label="Hasta"
          type="text" 
          pattern="[0-99]" maxlength="2"
          :v-model="age2"/>
      </div>

      <div class="field">
        <label>Duración:</label>
          <input type="time" name="time" :v-model="duration">
      </div>

		<v-card-actions>
			<v-spacer></v-spacer>
			<v-btn color="success" @click="analize">Analizar</v-btn>
		</v-card-actions>
    </div>
  </div>

    <v-row>
      <v-col v-for="statistic in statistics" :key="`${statistic.title}`" cols="6" md="3">
      <StatisticCard :statistic="statistic" v-if="showCards" :value="false" />
      </v-col>
    </v-row>

    <v-row>
    </v-row>
    
    <v-row>
      <v-col v-for="sale in sales" :key="`${sale.title}`" cols="12" md="4">
        <SalesGraph :sale="sale" />
      </v-col>
    </v-row>

  </v-container>
</template>

<script>
import StatisticCard from "../components/StatisticCard";
import SalesGraph from "../components/SalesGraph";
import moment from "moment";
import Result from "../core/model/result.model";
import ResultService from "../core/services/result.service";

export default {
  name: "DashboardPage",
  components: {
    StatisticCard,
    SalesGraph
  },

  data: () => {
    return {
      showCards: false,
      startDate: '',
      endDate: '',
      userType: '',
      age1: '',
      age2: '',
      duration: '',
      gender: '',
      counterUserTypePremium: 0,
      counterUserTypeFreemium: 0,
      badgesAwarded: [],
      topicsTalked: [],
      segments: [],
      
      statistics:[
      {"title": "Todos los Usuarios", value: "6"},
      //{"title": "Usuarios Premium", value: "0"},
      {"title": "Usuarios Free", value: "6"},
      {"title": "Segmentos", value: "upc.edu.pe"},

      //{"title": "Usuarios Free", "value": this.counterUserTypeFreemium},
      {"title": "Usuarios Premium", value: this.counterUserTypePremium},
      //{"title": "Total Usuarios", value: this.response.data.count}, 
      //{"title": "Intereses en común", value: this.topicsTalked}, 
      //{"title": "Segmentos", value: this.segments}, 
      //{"title": "Insignias", value: this.badgesAwarded},
      ],

      sales: [
      { "title": "Edad de Usuarios", "sales": [42, 46, 75, 51, 59, 61, 50, 39], "color": "cyan", "labels": [18, 19, 20, 21, 22, 23, 24, 25] },
      {"title": "Duración de Chats", "sales": [25, 23, 33, 28, 43], "color": "teal", "labels": ["1min", "2min", "3min", "4min", "5min"]}, 
      {"title": "Usuarios Registrados", "sales": [21, 24, 27, 31, 44, 20, 34, 34, 22, 29, 33, 30], "color": "blue", "labels": ["Ene", "Feb", "Mar", "Abr", "May", "Jun", "Jul", "Ago", "Sep", "Oct", "Nov", "Dic"]}
      ]
    };
  },

  filters: {
    formatDate: function(date) {
      if (date) {
        return moment(new Date(date)).format("MMMM Do YYYY, h:mm:ss a")
        // var date = new Date("2013-03-10T02:00:00Z"); date.toISOString().substring(0, 10);
      }
    }
  },

  methods: {

    async analize(){
      
      try{

        var mydate = new Date(this.startDate);
        var mydate2 = new Date(this.endDate);

        var filterResult = new Result();
        
          filterResult.userType = this.userType;
          filterResult.startTime = mydate.toISOString();
          filterResult.endTime = mydate2.toISOString();
          filterResult.duration = this.duration;
          filterResult.startYears = this.age1;
          filterResult.endYears = this.age2;
          //gender: this.$data.gender,
        
        const response = await ResultService.sendResult(filterResult);
        console.log(response)
        StatisticCard = true;

        for (let i = 0; i < response.data.count; i++ ){
          if (response.data[i].userType === "premium" ){
            this.counterUserTypePremium = this.counterUserTypePremium+1;
          }
          if (response.data[i].userType === "freemium" ){
            this.counterUserTypeFreemium = this.counterUserTypeFreemium+1;
          }
          this.badgesAwarded.push(response.data[i].badgesAwarded);
          this.topicsTalked.push(response.data[i].topicsTalked);
          this.segments.push(response.data[i].segments);
        }
         console.log(this.counterUserTypePremium);
      } catch (error){
        if (this.startDate == "" ||  this.endDate == "" ){
          return confirm("Debe elegir una fecha de inicio y fin de forma obligatoria para continuar con el análisis");
        } if (this.endDate < this.startDate){
          return confirm("La fecha de inicio debe ser menor a la fecha fin");
        } else if (this.startDate != "" && this.endDate == ""){
          return confirm("Debe elegir una fecha de inicio y fin de forma obligatoria para continuar con el análisis");
        } else if (this.startDate == "" && this.endDate != ""){
          return confirm("Debe elegir una fecha de inicio y fin de forma obligatoria para continuar con el análisis");
        } else this.showCards = true; }
    }
  },
}

</script>

<style scoped>
body {
    overflow: hidden;
}
h3 {
  margin: 40px 0 0;
}
a {
  color: #42b983;
}
.event-listing {
  overflow: hidden;
}
.table-wrapper {
    overflow-x: auto;
}
.table-header {
  border-bottom: 2px #000 solid;
}
.search-row {
  max-width: 1600px;
  margin: 0 auto;
  padding: 20px;
  background-color: #71bbe4;
  display: block;
}
.search-row .field {
  text-align: center;
  margin-bottom: 11px;
}
.search-row label {
  color: #2b0404;
}
.search-row input,
.search-row select {
  width: 120px;
  height: 30px;
  padding-left: 3px;
  margin-left: 10px;
  background-color: #9ee2fda8;
}
.event-table {
  min-width: 900px;
  max-width: 1200px;
  margin: 0 auto;
  padding: 20px;
}
.table-row{
  display: flex;
  align-items: center;
  flex-direction: row;
  justify-content: flex-start;
}
.table-row .row-col{
  padding: 15px 0;
  text-align: left;
  text-transform: capitalize;
  font-size: 14px;
}
.table-row .row-col.sm{
  flex-basis: 15%;
}
.table-row .row-col.md{
  flex-basis: 20%;
}
.table-row .row-col.lg{
  flex-basis: 50%;
}
@media (min-width: 576px){
  .search-row {
    display: flex;
    align-items: center;
    justify-content: space-evenly;
  }
  .search-row .field{
    margin-bottom: 0px;
  }
  .search-row input,
.search-row select{
  width: 137px;
 }
}
</style>
