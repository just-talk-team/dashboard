<template>
	<v-app>
		<v-app-bar app color="primary" dark>
			<v-toolbar-title>Just Talk Dashboard</v-toolbar-title>
			<v-spacer></v-spacer>
			<v-btn
				v-for="link in links"
				:key="`${link.label}-header-link`"
				text
				rounded
				:to="link.url"
			>
				{{ link.label }}
			</v-btn>
			<v-btn @click="toggleTheme" text rounded>Modo Oscuro</v-btn>
		</v-app-bar>
		<v-main>
			<router-view></router-view>
		</v-main>
		<v-footer color="primary lighten-1" padless>
			<v-layout justify-center wrap>
				<v-btn
					v-for="link in links"
					:key="`${link.label}-footer-link`"
					color="white"
					text
					rounded
					class="my-2"
					:to="link.url"
				>
					{{ link.label }}
				</v-btn>
				<v-flex primary lighten-2 py-4 text-center white--text xs12>
					{{ new Date().getFullYear() }} — <strong>Just Talk Dashboard</strong>
				</v-flex>
			</v-layout>
		</v-footer>
	
	</v-app>
</template>

<script>


export default {
	name: 'App',
	
	data() {
		
		return {
			links: [
				{
					label: 'Inicio',
					url: '/'
				},
				{ 
					label: "Login",
					url: '/login'
				},
			]
		}
	},
	methods: {
		toggleTheme() {
			this.$vuetify.theme.themes.dark.anchor = '#41b883'
			this.$vuetify.theme.dark = !this.$vuetify.theme.dark
		}
	}
}
</script>
