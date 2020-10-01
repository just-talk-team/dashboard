<template>
  <v-data-table
    :headers="headers"
    :items="users"
    :items-per-page="10"
    class="elevation-1"
    @click:row="selectRow"
    :multi-sort="true"
  ></v-data-table>
</template>

<script>
export default {
  name: 'UsersTable',
  props: {
    users: {
      type: Array,
      required: true
    }
  },
  data: () => ({
    headers: [
      { text: 'ID', value: 'id' },
      { text: 'Usuario', value: 'name' },
      { text: 'Género', value: 'title' },
      { text: 'Edad', value: 'age' }
    ]
  }),
  methods: {
    selectRow(event) {
      const user = {
        name: event.name,
        title: event.title
      }

      this.$emit('select-user', user)
    }
  }
}
</script>

<style lang="scss" scoped></style>
