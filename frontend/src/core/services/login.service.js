import axios from "axios";
import { environments } from "../../environments/environments";
import User from "../model/user.model"
export default class LoginService {
  
static async auth(user, password) {
    var userAdmin = new User(user, password)
    return await axios.post(
        `${environments.api}/dashboard/api/user/login`, userAdmin);
}

static getUserAuth() {
    return JSON.parse(sessionStorage.getItem("user"));
}

static saveUserAuth(userAuth) {
    sessionStorage.setItem("user", JSON.stringify(userAuth));
}

}