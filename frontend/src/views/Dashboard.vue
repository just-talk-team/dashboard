<template>
  <v-container>
    <br><h1 class="text-center">Just Talk Dashboard</h1><br>

<div class="event-listing">
    <div class="search-row">

      <div class="field">
        <label>Fecha Inicio:</label>
        <input type="date" name="startDate" :v-model="startDate" />
      </div>
      <div class="field">
        <label>Fecha Fin:</label>
        <input type="date" name="endDate" :v-model="endDate" />
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
        <StatisticCard :statistic="statistic" />
      </v-col>
    </v-row>

    <v-row>
    </v-row>
    <v-snackbar v-model="snackbar" :left="$vuetify.breakpoint.lgAndUp">
      <v-btn color="white" text @click="snackbar = false">x</v-btn>
    </v-snackbar>
    
  </v-container>
</template>

<script>
import StatisticCard from "../components/StatisticCard";
import moment from "moment";
import Result from "../core/model/result.model";
import ResultService from "../core/services/result.service";

export default {
  name: "DashboardPage",
  components: {
    StatisticCard
  },

  data: () => {
    return {
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
      // Mockeado: {"title": "Usuarios Free", value: "10"},
      {"title": "Usuarios Free", value: this.counterUserTypeFreemium},
      {"title": "Usuarios Premium", "value": this.counterUserTypePremium},
      {"title": "Total Usuarios", "value": this.response.data.count}, 
      {"title": "Intereses en común", "value": this.topicsTalked}, 
      {"title": "Segmentos", "value": this.segments}, 
      {"title": "Insignias", "value": this.badgesAwarded},
      ]
    };
  },

  filters: {
    formatDate: function(date) {
      if (date) {
        moment(new Date(date)).format('DD/MM/YYYY')
      }
    }
  },

  methods: {

    async analize(){
      try{
        var filterResult = new Result({
          userType: this.$data.userType,
          startDate: this.$data.startDate,
          endDate: this.$data.endDate,
          duration: this.$data.duration,
          age1: this.$data.age1,
          age2: this.$data.age2,
          gender: this.$data.gender,
        });

        const response = await ResultService.analize(filterResult);
        

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
      } catch (error){
        if (this.endDate == "" ||  this.endDate == "" ){
          confirm("Debe elegir una fecha de inicio y fin de forma obligatoria para continuar con el análisis");
        } else if (this.endDate < this.startDate){
          confirm("La fecha de inicio debe ser menor a la fecha fin");
        } else if (this.startDate != "" && this.endDate == ""){
          confirm("Debe elegir una fecha de inicio y fin de forma obligatoria para continuar con el análisis");
        } else if (this.startDate == "" && this.endDate != ""){
          confirm("Debe elegir una fecha de inicio y fin de forma obligatoria para continuar con el análisis");
      } }
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
