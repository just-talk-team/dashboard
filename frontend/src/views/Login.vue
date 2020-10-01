<template>
	<v-card width="400" class="mx-auto mt-5">
		<v-card-title>
			<h1 class="display-1">Iniciar Sesión</h1>
		</v-card-title>
		<v-card-text>
			<v-form>
				<v-text-field 
					label="Usuario" 
					type= "text"
					v-model="user" 
					prepend-icon="mdi-account-circle" />
				
				<v-text-field
					:type="showPassword ? 'text' : 'password'"
					label="Contraseña"
					v-model="password"
					prepend-icon="mdi-lock"
					:append-icon="showPassword ? 'mdi-eye' : 'mdi-eye-off'"
					@click:append="showPassword = !showPassword"
				/>
			</v-form>
		</v-card-text>
		<v-divider></v-divider>
		<v-card-actions>
			<v-btn to="/report" color="success">Contactar Soporte</v-btn>
			<v-spacer></v-spacer>
			<v-btn color="info" @click="auth">Iniciar Sesión</v-btn>
		</v-card-actions>
	</v-card>
</template>

<script>

import LoginService from  "../core/services/login.service";

    export default {
		name: 'LoginPage',
	
		
        data: function() {
            return {
				showPassword: false,
				user: "",
				password: "",
		
            };
        },
        methods: {
			async auth() {
				try{
				await LoginService.auth(this.$data.user, this.$data.password);
					console.log("logueado");
		
	
					this.$router.push("/dashboard");
				} catch (error){
					if (this.user.length<1 || this.password.length<1){
						confirm("Verificar que el campo usuario y/o contraseña no este vacío.");
						console.log("campos vacios");
					}
					else
						confirm("Usuario o contraseña incorrecto.") 
						console.log("usuario no válido")
				}
			}
		}
	}
	
</script>

<style></style>