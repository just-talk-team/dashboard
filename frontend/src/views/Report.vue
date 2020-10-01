<template>
  <div>
    <v-container>
      <v-row>
        <v-col>
          <h1 justify-center>Reportar un problema</h1>
          <div></div>
          <v-form ref="signupForm" v-model="formValidity">
            <v-text-field label="Correo" type="email" v-model="email" :rules="emailRules" required></v-text-field>
            <v-autocomplete label="¿Qué navegador usa?" :items="browsers"></v-autocomplete>
            <v-file-input label="Adjunte captura de pantalla del error"></v-file-input>
            <v-text-field label="Detalle su reporte" ></v-text-field>
            <v-checkbox
              label="Declaro que los datos enviados son reales y no han sido manipulados."
              v-model="agreeToTerms"
              :rules="agreeToTermsRules"
              required
            ></v-checkbox>
            <v-btn type="submit" class="mr-4" color="primary" :disabled="!formValidity">Enviar</v-btn>
            <v-btn class="mr-4" color="success" @click="validateForm">Validar</v-btn>
            <v-btn color="warning" class="mr-4" @click="resetValidation">Reset Validacion</v-btn>
            <v-btn color="error" @click="resetForm">Reset</v-btn>
          </v-form>
        </v-col>
      </v-row>
    </v-container>
  </div>
</template>

<script>
export default {
  data: () => ({
    formValidity: false,
    agreeToTerms: false,
    agreeToTermsRules: [
      value => !!value || "Debe aceptar las condiciones"
    ],
    email: "",
    emailRules: [
      value => !!value || "Coreo es obligatorio",
      value => value.indexOf("@") !== 0 || "Debe ingresar un correo válido",
      value => value.includes("@") || "El correo debe contener un @",
      value =>
        value.indexOf(".") - value.indexOf("@") > 1 ||
        "El correo tener un dominio válido",
      value =>
        value.indexOf(".") <= value.length - 3 ||
        "La direccion de correo debe ser completa"
    ],
    browsers: ["Chrome", "Firefox", "Safari", "Edge", "Opera"],
    //birthday: ""
  }),
  methods: {
    resetValidation() {
      this.$refs.signupForm.resetValidation();
    },
    resetForm() {
      this.$refs.signupForm.reset();
    },
    validateForm() {
      this.$refs.signupForm.validate();
    }
  }
};
</script>

<style scoped>
</style>