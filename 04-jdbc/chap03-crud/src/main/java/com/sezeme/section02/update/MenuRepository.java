package com.sezeme.section02.update;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

import static com.sezeme.common.JDBCTemplate.close;

public class MenuRepository {
    public int updateMenu(Connection con, Menu menu) {
        PreparedStatement pstmt = null;
        Properties properties = new Properties();
        int result = 0;

        // xml 가져오려면 properties
        try {
            properties.loadFromXML(new FileInputStream(
                    "src/main/java/com/sezeme/mapper/MenuMapper.xml"
            ));
            String sql = properties.getProperty("updateMenu");

            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, menu.getMenuName());
            pstmt.setInt(2, menu.getMenuPrice());
            pstmt.setInt(3, menu.getMenuCode());

            result = pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InvalidPropertiesFormatException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
        }

        return result;
    }
}
