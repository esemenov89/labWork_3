package code.model.dao;

import code.model.ConnectionPool;
import code.model.pojo.StorageUnit;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.HashSet;

/**
 * Created by admin on 22.04.2017.
 */
public class StorageUnitDAOImpl implements StorageUnitDAO {

    private static final Logger LOGGER = Logger.getLogger(StorageUnitDAOImpl.class);

    public HashSet<StorageUnit> getAllStorageUnits(){
        StorageUnit storageUnit=null;
        HashSet<StorageUnit> storageUnits = new HashSet<>();

        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection
                     .prepareStatement( "SELECT * FROM ELCATALOG")) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                storageUnit = createEntity(resultSet);
                storageUnits.add(storageUnit);
            }
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        catch (Exception e){
            LOGGER.error(e);
        }
        return storageUnits;
    }

    private StorageUnit createEntity(ResultSet resultSet) throws SQLException {
        return new StorageUnit(resultSet.getString("AUTHOR"),
                resultSet.getString("TITLE"),
                resultSet.getString("PUBLISHING_HOUSE"),
                resultSet.getString("CITY"),
                resultSet.getInt("YEAR"),
                resultSet.getInt("PAGES_COUNT"),
                resultSet.getString("ISN"),
                resultSet.getString("TEXT"));
    }
}
