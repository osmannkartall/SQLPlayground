import React from 'react';
import axios from 'axios';
import Tables from "../Tables/Tables";
import Table from "../Tables/Table/Table";

class Database extends React.Component {
	/*
    TODO: Records ve record table'ları query değiştiği an gereksiz yere re-render ediliyor
    TODO: Id en başta gelmek yerine en sonda geliyor.
  */
  baseUrl = "http://localhost:8081";
  errorTitle = "QUERY RESULTS";

	constructor(props) {
		super(props)
		this.state = {
			query: "",
      showQueryResult: false,
      queryResult: null,
      records: {},
    }
  }
    
  componentDidMount() {
    let url = this.baseUrl + "/tables"; 
    axios.get(url).then(res => {
      let tables = res.data;
  
      const requests = [];
      tables.forEach(table => requests.push(
        axios.get(this.baseUrl + "/" + table))
      );

      axios.all(requests).then(axios.spread((...responses) => {
        responses.forEach( (res, i) => {
          const newRecords = {...this.state.records};
          if (res.data._embedded) {
            if (res.data._embedded[tables[i]] && res.data._embedded[tables[i]].length) {
              newRecords[tables[i]] = res.data._embedded[tables[i]];
            }
          }
          // This is for the tables have composite primary key.
          else {
            newRecords[tables[i]] = res.data;
          }
          this.setState( {records: newRecords} );
        });
      })).catch(errors => {
        console.log(errors);
      });
    });
  }

	sendQuery = () => {
		const url = this.baseUrl + "/query";
    const config = { 
      headers: {'Content-Type' : 'application/json;charset=UTF-8'}
    }

		axios.post(url, this.state.query, config).then(res => {
      let queryResult = res.data;
      if (!res.data.length) {
        queryResult = [{}];
      }
      this.setState({
        queryResult: <Table records={queryResult} title={this.errorTitle}/>
      });
		}).catch(err => {
      let message = ""
      let status = ""
      if (err.response.data) {
        message = err.response.data.error;
        status = err.response.status;
      }
      const errorMessage = [{
        "message": message +
        ", Status Code: " + status
      }];
      this.setState({
        queryResult: <Table records={errorMessage} title={this.errorTitle}/>
      });
    });
	}

	queryChangedHandler = (event) => {
		this.setState({
			query: event.target.value, 
		});
		console.log(event.target.value);
	}

	render() {
		return (
			<div>
				<div className="wrapper-sql">
					<h1>SQL Statement</h1>
          <textarea 
            className="tarea" 
            onChange={this.queryChangedHandler}
            value={this.state.query}>
          </textarea>
          <button className="button button1" 
            onClick={this.sendQuery}>
              Run Query
          </button>
					{this.state.queryResult}
				</div>
        <Tables records={this.state.records}/>
			</div>
		)
	}
}

export default Database;