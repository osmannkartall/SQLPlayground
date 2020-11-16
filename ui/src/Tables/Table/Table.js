import React from "react";

const table = (props) => {
  const headers = Object.keys(props.records[0])
  if (headers.includes("_links"))
    headers.pop("_links");
  console.log("headers-->", props.records[0]);
  
  return (
    <div>
      <h1 id='title'>{props.title}</h1>
      <table id='table'>
        <thead>
          <tr>
            {
              headers.map((key, index) => {
                return <th key={index}>{key}</th>
              })
            }
          </tr>
        </thead>
        <tbody>
          {
            props.records.map((record, index) => {
              return (
                <tr key={index}>
                  {
                    headers.map((key, ind) => {
                      return <td key={ind}>{record[key]}</td>
                    })
                  }
                </tr>
              );
            })
          }
        </tbody>
      </table>
    </div>
  );
}

export default table;