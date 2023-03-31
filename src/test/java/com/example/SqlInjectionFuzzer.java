package com.example; 

import com.code_intelligence.jazzer.api.FuzzedDataProvider;
import java.sql.SQLException;
import cli.java.demo.ci.SqlInjection;
import com.code_intelligence.jazzer.api.FuzzerSecurityIssueHigh;
import com.code_intelligence.jazzer.junit.FuzzTest;

public class SqlInjectionFuzzer {
    
    private static SqlInjection project;
    
    public static void fuzzerInitialize() throws SQLException {
        // Initialize the project and connect to the database
        project = new SqlInjection();
        project.connect();
    }
    
    public static void fuzzerTestOneInput(FuzzedDataProvider data) throws SQLException {
        project.getUserByUsername(data.consumeString(100));
    }
}
