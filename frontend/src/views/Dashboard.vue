<template>
  <v-container>
    <br><h1 class="text-center">Just Talk Dashboard</h1><br>

<div class="event-listing">
    <div class="search-row">

      <div class="field">
        <label>Fecha Inicio:</label>
        <input type="date" name="startDate" v-model="filter_sd" />
      </div>
      <div class="field">
        <label>Fecha Fin:</label>
        <input type="date" name="endDate" v-model="filter_ed" />
      </div>

      <div class="field">
        <label>Tipo de Usuario:</label>
        <select
          v-model="userType"
          name="userType">
          <option name="userType" value="everyone" selected>Todos</option>
          <option name="userType" value="free">Freemium</option>
          <option name="userType" value="premium">Premium</option>
        </select>
      </div>

      <div class="field">
        <label>Género:</label>
        <select
          v-model="gender"
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
					v-model="age1"/>
				<v-text-field
					label="Hasta"
          type="text" 
          pattern="[0-99]" maxlength="2"
          v-model="age2"/>
      </div>

      <div class="field">
        <label>Duración:</label>
          <input type="time" name="time" v-model="duration">
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
      <v-btn color="white" text @click="snackbar = false">Cerrar</v-btn>
    </v-snackbar>
    
  </v-container>
</template>

<script>
import StatisticCard from "../components/StatisticCard";
import moment from "moment";

export default {
  name: "DashboardPage",
  components: {
    StatisticCard
  },

  data() {
    return {
      loadNewContent: true,
      snackbar: false,
      filter_sd: "",
      filter_ed: "",
      userType: "",
      duration: "",
      gender: "",
      events: [],

      statistics:[
      {"title": "Usuarios Free", "value": ""},//userType.free },
      {"title": "Usuarios Premium", "value": ""},//userType.premium },
      {"title": "Total Usuarios", "value": ""}, //userType.everyone },
      {"title": "# en Edad Seleccionada", "value": ""},//userType.age },
      {"title": "Género Seleccionado", "value": ""}, //userType.gender }
      {"title": "Intereses en común", "value": ""}, //
      ],
      
    };
  },
  
  filters: {
    formatDate: function(date) {
      if (date) {
        return moment(String(date)).format("MMMM Do YYYY, h:mm:ss a");
      }
    }
  },

  methods: {

    analize(){
      if (this.filter_ed == "" ||  this.filter_ed == "" ){
          confirm("Debe elegir una fecha de inicio y fin de forma obligatoria para continuar con el análisis");
      }
      else if (this.filter_ed < this.filter_sd){
          confirm("La fecha de inicio debe ser menor a la fecha fin");
      }

      else if (this.filter_sd != "" && this.filter_ed == "")
        confirm("Debe elegir una fecha de inicio y fin de forma obligatoria para continuar con el análisis");
      
      else if (this.filter_sd == "" && this.filter_ed != "")
        confirm("Debe elegir una fecha de inicio y fin de forma obligatoria para continuar con el análisis");

      else {
      this.getEventsByUserType(this.userType).then(events => {
        this.events = events.filter(event => {
          var eventStartDate = new Date(event.start_time.substring(0, 10));
          if (this.filter_sd != "") {
            var filterStartDate = new Date(this.filter_sd);
          }
          if (this.filter_ed != "") {
            var filterEndDate = new Date(this.filter_ed);
          }
          else {
            return (
              eventStartDate >= filterStartDate &&
              eventStartDate <= filterEndDate
            );
          }
        });
      });
      }
    },

    GenerateACard() {
    },

  }
};
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
.table-row {
  display: flex;
  align-items: center;
  flex-direction: row;
  justify-content: flex-start;
}
.table-row .row-col {
  padding: 15px 0;
  text-align: left;
  text-transform: capitalize;
  font-size: 14px;
}
.table-row .row-col.sm {
  flex-basis: 15%;
}
.table-row .row-col.md {
  flex-basis: 20%;
}
.table-row .row-col.lg {
  flex-basis: 50%;
}
@media (min-width: 576px) {
  .search-row {
    display: flex;
    align-items: center;
    justify-content: space-evenly;
  }
  .search-row .field {
    margin-bottom: 0px;
  }
  .search-row input,
.search-row select {
  width: 137px;
 }
}
</style>
