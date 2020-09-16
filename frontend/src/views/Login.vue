<template>
    <section class="container-fluid">
        <div class="row justify-content-center">
            <div class="col-lg-4">
                <div class="login-panel bg-white text-left">
                    <div class="alert alert-primary" role="alert" :style="{opacity: isAlertShow ? 1 : 0}">
                        ¡Logueado exitosamente! <small>espera a ser redirigido.</small>
                        <loader-component width="30"></loader-component>
                    </div>
                    <h1 class="display-3 font-weight-bold">Just-Talk</h1>
                    <p class="font-weight-bold">Solo para administradores</p>
                    <br>
                    <form action="">
                        <div class="form-group">
                            <lable class="input-label">Usuario</lable>
                            <input type="email" class="form-control" placeholder="o e-mail">
                        </div>
                        <div class="form-group">
                            <lable class="input-label">Contraseña</lable>
                            <input type="password" class="form-control" placeholder="*******">
                        </div>
                        <br>
                        <div class="form-group d-flex justify-content-center">
                            <button class="btn btn-primary w-25" id="login" @click.prevent="login" v-if="!isLoggingIn">Ingresar</button>
                            <button class="btn btn-primary w-25" disabled @click.prevent="login" v-if="isLoggingIn"><loader-component width="30"></loader-component></button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </section>
</template>

<script>
import LoaderComponent from '../components/LoadingComponent'
import { setTimeout } from 'timers';

export default {
    components: { LoaderComponent },
    data() {
        return {
            isLoggingIn: false,
            isAlertShow: false
        }
    },
    methods: {
        login() {
            this.isLoggingIn = true
            setTimeout(() => {
                this.isLoggingIn = false
                this.isAlertShow = true
                setTimeout(() => this.redirect(), 1000)
            }, 1000)
        },

        redirect() {
            this.$router.push({name: 'dashboard'})
        }
    }
}
</script>

<style lang="scss">
.widget {
    margin: 0;
    height: unset;
}
.login-panel {
    position: relative;
    padding: 200px 0;
    .alert {
        opacity: 0;
        position: absolute;
        width: 100%;
        top: 100px;
        transition: all .5s;
        &.alert-primary {
            background-color: #007BFF;
            color: #fff;
            font-size: 18px;
            border: none;
        }
        .widget {
            position: absolute;
            right: 5px;
            top: 0;
            margin: 10px;
        }
    }
}
</style>