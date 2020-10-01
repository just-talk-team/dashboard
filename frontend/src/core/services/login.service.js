import axios from "axios";
import { environments } from "../../environments/environments";
export default class LoginService {
  
static async auth(username, password) {
    return await axios.post(
        `${environments.api}/dashboard/api/login/${username}/${password}`);
}

  static getUserAuth() {
    return JSON.parse(sessionStorage.getItem("user"));
  }

  static saveUserAuth(userAuth) {
    sessionStorage.setItem("user", JSON.stringify(userAuth));
  }
}