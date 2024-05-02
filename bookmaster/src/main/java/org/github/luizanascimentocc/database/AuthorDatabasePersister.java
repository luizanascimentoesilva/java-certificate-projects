package org.github.luizanascimentocc.database;

import org.github.luizanascimentocc.models.Author;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuthorDatabasePersister{
    public void getLastIndex(Statement st) throws SQLException {
        List<Author> authors = new ArrayList<Author>();
        String query = "select * from author order by id desc limit 1";
        ResultSet rs = st.executeQuery(query);

        while (rs.next()){
            System.out.println(rs.getString("id"));
        }
    }
}
