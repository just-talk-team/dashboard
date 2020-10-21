import axios from "axios";
import { environments } from "../../environments/environments";
import User from "../model/result.model"
export default class ResultService {
  
static async analize() {
    var result = new Result(userType)
    return await axios.post(
        `${environments.api}/dashboard/api/user/dashboard`, userType);
}

}