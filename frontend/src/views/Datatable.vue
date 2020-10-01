<template>
  <div class="datatable">
    <h1>Registro y totalidad de usuarios</h1>
    <v-data-table
      :headers="headers"
      :items="accounts"
      :search="search"
      sort-by="id"
      class="elevation-1"
    >
      <template v-slot:item.birthdate="{ item }">
        {{ formatDate(item.birthdate) }}
      </template>
      <template v-slot:top>
        <v-toolbar flat color="white">
          <v-toolbar-title>
            <v-text-field
              v-model="search"
              append-icon="mdi-magnify"
              label="Buscar"
              single-line
              hide-details
            ></v-text-field>
          </v-toolbar-title>
          <v-divider class="mx-4" inset vertical></v-divider>
          <v-spacer></v-spacer>
          <v-dialog v-model="dialog" max-width="600px">
            <template v-slot:activator="{ on, attrs }">
              <v-btn color="primary" dark class="mb-2" v-bind="attrs" v-on="on">Nueva Cuenta</v-btn>
            </template>
            <v-card>
              <v-card-title>
                <span class="headline">{{ formTitle }}</span>
              </v-card-title>

              <v-card-text>
                <v-container>
                  <v-row>
                    <v-col cols="12" sm="6" md="4">
                      <v-text-field v-model="editedItem.firstname" :counter="30" :rules="nameRules" label="Nombre"></v-text-field>
                    </v-col>
                    <v-col cols="12" sm="6" md="4">
                      <v-text-field v-model="editedItem.lastname" :counter="30" :rules="nameRules" label="Apellido"></v-text-field>
                    </v-col>
                    <v-col cols="12" sm="6" md="4">
                      <v-text-field v-model="editedItem.email"  :rules="[rules.required, rules.email]" label="Correo"></v-text-field>
                    </v-col>
                    <v-col cols="12" sm="6" md="4">
                      <v-dialog
                        ref="dialog"
                        v-model="modal"
                        :return-value.sync="editedItem.birthdate"
                        persistent
                        width="290px"
                      >
                        <template v-slot:activator="{ on, attrs }">
                          <v-text-field
                            v-model="editedItem.birthdate"
                            label="Fecha de Nacimiento"
                            readonly
                            v-bind="attrs"
                            v-on="on"
                          ></v-text-field>
                        </template>
                        <v-date-picker v-model="editedItem.birthdate" scrollable>
                          <v-spacer></v-spacer>
                          <v-btn text color="primary" @click="modal = false">Cancelar</v-btn>
                          <v-btn text color="primary" @click="$refs.dialog.save(editedItem.birthdate)">OK</v-btn>
                        </v-date-picker>
                      </v-dialog>
                    </v-col>
                       

                    <v-col cols="12" sm="6" md="4">
                      <v-switch
                        v-model="editedItem.active"
                        :label="`Active: ${editedItem.active.toString()}`"
                      ></v-switch>
                    </v-col>
                  </v-row>
                </v-container>
              </v-card-text>

              <v-card-actions>
                <v-spacer></v-spacer>
                <v-btn color="blue darken-1" text @click="close">Cancelar</v-btn>
                <v-btn color="blue darken-1" text @click="save">Guardar</v-btn>
              </v-card-actions>
            </v-card>
          </v-dialog>
        </v-toolbar>
      </template>
      <template v-slot:item.actions="{ item }">
        <v-icon small color="primary" class="mr-2" @click="editItem(item)">mdi-pencil</v-icon>
        <v-icon small color="red" @click="deleteItem(item)">mdi-delete</v-icon>
      </template>
      <template v-slot:no-data>
        <v-btn color="primary" @click="initialize">Reset</v-btn>
      </template>
    </v-data-table>
  </div>
</template>

<script>
import moment from "moment";

export default {
  data: () => ({
    date: new Date().toISOString().substr(0, 10),
    menu: false,
    modal: false,
      menu2: false,
    name: '',
      nameRules: [
        v => !!v || 'Nombre es requerido',
        v => (v && v.length <= 30) || 'Debe contener menos de 30 caracteres',
      ],
    rules: {
          required: value => !!value || 'Campo requerido',
          counter: value => value.length <= 20 || 'Max 20 caracteres',
          email: value => {
            const pattern = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
            return pattern.test(value) || 'Correo no válido'
      },
    },
    search: "",
    dialog: false,
    headers: [
      {
        text: "Nombre",
        align: "start",
        value: "firstname"
      },
      { text: "Apellido", value: "lastname" },
      { text: "Correo", value: "email" },
      { text: "Fecha de nacimiento", value: "birthdate" },
      { text: "Activo", value: "active" },
      { text: "Actiones", value: "actions" }
    ],
    accounts: [],
    editedIndex: -1,
    editedItem: {
      firstname: "aaa",
      lastname: "bb",
      email: "abc@gmail.com",
      birthdate: new Date().toISOString().substr(0, 10),
      active: true
    },
    defaultItem: {
      firstname: "aaaa",
      lastname: "bb",
      email: "abc@gmail.com",
      birthdate: new Date().toISOString().substr(0, 10),
      active: true
    }
  }),

  computed: {
    formTitle() {
      return this.editedIndex === -1 ? "Nueva Cuenta" : "Editar Cuenta";
    }
  },

  watch: {
    dialog(val) {
      val || this.close();
    }
  },

  created() {
    this.fetchAccounts();
  },

  methods: {
    fetchAccounts() {
      this.axios
        .get("http://localhost:9191/dashboard/api/accounts")
        .then(res => {
          console.log(res.data);
          this.accounts = res.data;
        })
        .catch(err => {
          console.log(err.res);
        });
    },
    initialize() {
      this.fetchAccounts();
    },
    editItem(item) {
      this.editedIndex = this.accounts.indexOf(item);
      this.editedItem = Object.assign({}, item);
      this.dialog = true;
    },

    deleteItem(item) {
      const index = this.accounts.indexOf(item);
      if (
        confirm("¿Está seguro de borrar ese usuario?") &&
        this.accounts.splice(index, 1)
      ) {
        this.axios
          .delete("http://localhost:9191/dashboard/api/accounts/"+ item.id)
          .then(res => {
            console.log(res.data);
            if (res.data) {
              this.fetchAccounts();
            } else {
              console.log("No se puedo borrar");
            }
          });
      }
    },

    close() {
      this.dialog = false;
      this.$nextTick(() => {
        this.editedItem = Object.assign({}, this.defaultItem);
        this.editedIndex = -1;
      });
    },

    save() {
      if (this.editedIndex > -1) {
        console.log("datos actualizados");
        console.log(this.editedItem);

        this.axios
          .put("http://localhost:9191/dashboard/api/accounts/"+this.editedItem.id, {
            id: this.editedItem.id,
            firstname: this.editedItem.firstname,
            lastname: this.editedItem.lastname,
            email: this.editedItem.email,
            birthdate: this.editedItem.birthdate,
            active: this.editedItem.active
          })
          .then(res => {
            console.log("Actualizado", res.data);
          });

        Object.assign(this.accounts[this.editedIndex], this.editedItem);
      } else {
        console.log("datos creados");
        console.log(this.editedItem);

        this.axios
          .post("http://localhost:9191/dashboard/api/accounts", {
            id: this.editedItem.id,
            firstname: this.editedItem.firstname,
            lastname: this.editedItem.lastname,
            email: this.editedItem.email,
            birthdate: this.editedItem.birthdate,
            active: this.editedItem.active
          })
          .then(res => {
            console.log("Datos agregados", res.data);
            this.accounts.push(res.data);
          });
      }

      this.close();
    },
    formatDate(value) {
      return moment(value).format("YYYY-MM-DD")
    }
  }
};
</script>

