<template>

 <div>User
 
  <input v-model="user">
 </div>

</template>


<script>

export default {

 data: function () {

  return {

   userActive: false,
   user: ''

  };

 },

 methods: {

  activeUser: function() {

    this.userActive = true;

  }

 },

 computed: {
    error () {
      return this.user.trim().length < 7
        ? 'Por favor ingrese un nombre de usuario más largo'
        : ''
    }
  }

};

</script>


<style>
</style>