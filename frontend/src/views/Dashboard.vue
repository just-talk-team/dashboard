<template>
  <v-container>
    <h1 class="text-center">Just Talk Dashboard</h1>
    <v-row>
      <v-col v-for="sale in sales" :key="`${sale.title}`" cols="12" md="4">
        <SalesGraph :sale="sale" />
      </v-col>
    </v-row>

    <v-row>
      <v-col v-for="statistic in statistics" :key="`${statistic.title}`" cols="6" md="3">
        <StatisticCard :statistic="statistic" />
      </v-col>
    </v-row>

    <v-row>
      <v-col cols="12" md="8">
        <UsersTable :users="users" @select-user="setUser" />
      </v-col>
      <v-col cols="12" md="4">
        <EventTimeline :timeline="timeline" />
      </v-col>
    </v-row>

    <v-snackbar v-model="snackbar" :left="$vuetify.breakpoint.lgAndUp">
      Has seleccionado al usuario {{ selectedUser.name }},
      {{ selectedUser.title }}
      <v-btn color="white" text @click="snackbar = false">Cerrar</v-btn>
    </v-snackbar>
  </v-container>
</template>

<script>
import UsersTable from "../components/UsersTable";
import EventTimeline from "../components/EventTimeline";
import SalesGraph from "../components/SalesGraph";
import StatisticCard from "../components/StatisticCard";

import usersData from "../data/users.json";
import timelineData from "../data/timeline.json";
import salesData from "../data/sales.json";
import statisticsData from "../data/statistics.json";

export default {
  name: "DashboardPage",
  components: {
    UsersTable,
    EventTimeline,
    SalesGraph,
    StatisticCard
  },
  data() {
    return {
      loadNewContent: false,
      users: usersData,
      sales: salesData,
      selectedUser: {
        name: "",
        title: ""
      },
      snackbar: false,
      statistics: statisticsData,
      timeline: timelineData
    };
  },
  methods: {
    setUser(event) {
      this.snackbar = true;
      this.selectedUser.name = event.name;
      this.selectedUser.title = event.title;
    },
    showMoreContent(entries) {
      this.loadNewContent = (entries[0].isIntersecting)

    }
  }
};
</script>
