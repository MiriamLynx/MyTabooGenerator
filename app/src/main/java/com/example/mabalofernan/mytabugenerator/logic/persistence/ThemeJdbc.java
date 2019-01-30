package com.example.mabalofernan.mytabugenerator.logic.persistence;

import com.example.mabalofernan.mytabugenerator.logic.persistence.connection.Jdbc;
import com.example.mabalofernan.mytabugenerator.model.Theme;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ThemeJdbc {

    private static Connection con = null;

    public List<Theme> getThemes() {

        final String GET_THEMES = "select * from public.\"Theme\"";
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Theme> themes = new ArrayList<Theme>();

        try {

            con = Jdbc.getConnection();
            ps = con.prepareStatement(GET_THEMES);
            rs = ps.executeQuery();

            while (rs.next()) {

                Theme theme = new Theme();
                theme.setId(rs.getLong("id"));
                theme.setDescription(rs.getString("description"));
                themes.add(theme);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception ex) {
                }
            }
            ;
            if (ps != null) {
                try {
                    ps.close();
                } catch (Exception ex) {
                }
            }
            ;
            if (con != null) {
                try {
                    con.close();
                } catch (Exception ex) {
                }
            }
            ;
        }
        return themes;

    }
}
