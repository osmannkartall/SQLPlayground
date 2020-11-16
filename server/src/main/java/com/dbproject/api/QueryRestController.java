package com.dbproject.api;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.springframework.web.bind.annotation.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class QueryRestController {
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/getir_app?serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "password";
    private static Connection conn = null;
    private static Statement stmt = null;

    @RequestMapping(value="/query", method=RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public JSONArray sendQuery(@RequestBody String query) {
        JSONArray response = new JSONArray();
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            boolean isResultSet = stmt.execute(query);
            if (isResultSet) {
                ResultSet rs = stmt.executeQuery(query);
                ResultSetMetaData rsmd = rs.getMetaData();
                while(rs.next()) {
                    int numColumns = rsmd.getColumnCount();
                    JSONObject obj = new JSONObject();
                    for (int i=1; i<=numColumns; i++) {
                        String column_name = rsmd.getColumnName(i);
                        obj.put(column_name, rs.getObject(column_name));
                    }
                    response.add(obj);
                }
                rs.close();
            }
            stmt.close();
            conn.close();
            System.out.println("Query (" + query + ") is successful.");
        }
        catch (Exception se) {
            JSONObject obj = new JSONObject();
            obj.put("message", "SQL Syntax-Error");
            response.add(obj);
            se.printStackTrace();
        }
        finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            }
            catch (SQLException ignored) {}
            try {
                if (conn != null) {
                    conn.close();
                }
            }
            catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return response;
    }

    // TODO: Duplicate Code!
    @GetMapping("/tables")
    public List<String> getTableNames() {
        List<String> tableNames = new ArrayList<>();
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            ResultSet rs = conn.getMetaData().getTables("getir_app", null, null, new String[] {"TABLE"});
            while (rs.next()) {
                tableNames.add(rs.getString(3));
            }
            rs.close();
            conn.close();
        }
        catch (Exception se) {
            se.printStackTrace();
        }
        finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            }
            catch (SQLException ignored) {}
            try {
                if (conn != null) {
                    conn.close();
                }
            }
            catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return tableNames;
    }
}
