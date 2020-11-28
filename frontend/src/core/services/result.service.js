import axios from "axios";
import { environments } from "../../environments/environments";
export default class ResultService {
  
static async sendResult(result) {
        return await axios.post(
            `${environments.api}/dashboard/api/result/search`, result);
    }        
}
