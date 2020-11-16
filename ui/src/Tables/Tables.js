import React from "react";
import Table from "./Table/Table";

const tables = (props) => {
  const keys = Object.keys(props.records);
  return keys.map( (key, index) => {
    return (
      <Table 
        key={index}
        records={props.records[key]}
        title={key}/>
    );
  });
}

export default tables;