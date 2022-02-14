package jdbc;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.*;

public class ImagesDao {

    private DataSource dataSource;

    public ImagesDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void saveImage(String filename, InputStream is) {
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement("insert into images (filename, content) values (?, ?)")
        ) {
            Blob blob = connection.createBlob();
            fillBlob(is, blob);
            statement.setString(1, filename);
            statement.setBlob(2, blob);
            statement.executeUpdate();
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot insert image", sqle);
        }
    }

    public InputStream getImageByName(String name) {
        try (Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("select content from images where filename = ?")) {
            statement.setString(1, name);
            return readInputStreamFromStatement(statement);

        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot read image", sqle);
        }
    }

    private InputStream readInputStreamFromStatement(PreparedStatement statement) throws SQLException {
        try (ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                Blob blob = resultSet.getBlob("content");
                return blob.getBinaryStream();
            }
            throw new IllegalStateException("Not found");
        }
    }

    private void fillBlob(InputStream is, Blob blob) throws SQLException {
        try (OutputStream os = blob.setBinaryStream(1)) {
            is.transferTo(os);
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot write blob", ioe);
        }
    }
}
