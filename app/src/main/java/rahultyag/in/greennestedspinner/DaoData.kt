package rahultyag.`in`.greennestedspinner

import Area
import Country
import Employee
import Region
import Zone
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface DaoData {

    //Area
    @Query("SELECT * FROM Area")
    fun getAllArea(): List<Area>

    @Query("SELECT * FROM Area WHERE area LIKE :title")
    fun findAreaById(title: String): Area

    @Insert
    fun insertAllArea(vararg area: Area)

    @Delete
    fun deleteArea(area: Area)

    @Update
    fun updateArea(vararg area: Area)

    //Country

    @Query("SELECT * FROM Country")
    fun getAllCountry(): List<Country>

    @Query("SELECT * FROM Country WHERE country LIKE :countrys")
    fun findCountryById(countrys: String): Country

    @Insert
    fun insertAllCountry(vararg country: Country)

    @Delete
    fun deleteCountry(countrys: Country)

    @Update
    fun updateCountry(vararg area: Area)


    //Employee

    @Query("SELECT * FROM Employee")
    fun getAllEmployee(): List<Employee>

    @Query("SELECT * FROM Employee WHERE area LIKE :areas")
    fun findEmployeeById(areas: String): Country

    @Insert
    fun insertAllEmployee(vararg employee: Employee)

    @Delete
    fun deleteEmployee(employee: Employee)

    @Update
    fun updateEmployee(vararg employee: Employee)


    //Region

    //Employee

    @Query("SELECT * FROM Region")
    fun getAllRegion(): List<Region>

    @Query("SELECT * FROM Region WHERE region LIKE :regions")
    fun findRegionById(regions: String): Region

    @Insert
    fun insertAllRegion(vararg region: Region)

    @Delete
    fun deleteRegion(region: Region)

    @Update
    fun updateRegion(vararg region: Region)

    //Zone

    @Query("SELECT * FROM Zone")
    fun getAllZone(): List<Zone>

    @Query("SELECT * FROM Zone WHERE zone LIKE :zones")
    fun findZoneId(zones: String): Zone

    @Insert
    fun insertAllZone(vararg zone: Zone)

    @Delete
    fun deleteZone(zone: Zone)

    @Update
    fun updateZone(vararg zone: Zone)
}