import axios from "axios";
import { environments } from "../../environments/environments";
import Result from "../model/result.model"
export default class ResultService {
  
static async analize() {
    getData = (query) => {
        var result = new Result(userType)
        return await axios.post(
            `${environments.api}/dashboard/api/result/search`, userType)
            .then(res => res.json())
            .then(data => data.statuses)
            .then(statuses => statuses.filter(filterData))
            .then(results => this.setState({result:results}))
    }        
}

}