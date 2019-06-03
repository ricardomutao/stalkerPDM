package br.edu.iftm.stalkerricardomutao.data;

import android.content.ContentValues;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

public class DummyData {

    public static final void createData(SQLiteDatabase db){
        ArrayList<ContentValues> values = new ArrayList<>();

        ContentValues cv;
        /*cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Gipsy Castenda");
        cv.put(DBSchema.Contact.PNUMBER, "766-553-9253");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Rozele Kynge");
        cv.put(DBSchema.Contact.PNUMBER, "302-412-1174");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Nappy Cyster");
        cv.put(DBSchema.Contact.PNUMBER, "879-529-1872");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Daryn Dives");
        cv.put(DBSchema.Contact.PNUMBER, "756-715-9736");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Nathanial Hartzog");
        cv.put(DBSchema.Contact.PNUMBER, "946-557-9298");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Rubia Blenkensop");
        cv.put(DBSchema.Contact.PNUMBER, "386-834-3056");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Levin Romayn");
        cv.put(DBSchema.Contact.PNUMBER, "550-751-3725");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Sallee Minnette");
        cv.put(DBSchema.Contact.PNUMBER, "479-277-6528");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Kenny Christoffersen");
        cv.put(DBSchema.Contact.PNUMBER, "485-980-4300");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Marika Jeandet");
        cv.put(DBSchema.Contact.PNUMBER, "607-126-8673");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Eugenio Reagan");
        cv.put(DBSchema.Contact.PNUMBER, "823-476-9929");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Eldredge Titheridge");
        cv.put(DBSchema.Contact.PNUMBER, "471-946-1598");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Aleta Drewes");
        cv.put(DBSchema.Contact.PNUMBER, "158-724-8416");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Sylvia Lammerding");
        cv.put(DBSchema.Contact.PNUMBER, "517-526-0353");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Carrol Klaiser");
        cv.put(DBSchema.Contact.PNUMBER, "458-688-4171");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Clareta Filochov");
        cv.put(DBSchema.Contact.PNUMBER, "404-503-9431");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Juliette Charlo");
        cv.put(DBSchema.Contact.PNUMBER, "625-235-5362");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Emmi Clericoates");
        cv.put(DBSchema.Contact.PNUMBER, "578-876-3343");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Garvin Feilden");
        cv.put(DBSchema.Contact.PNUMBER, "226-774-5236");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Babara Wrathmall");
        cv.put(DBSchema.Contact.PNUMBER, "911-758-2929");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Michaeline Ellerker");
        cv.put(DBSchema.Contact.PNUMBER, "112-551-7002");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Reyna Sims");
        cv.put(DBSchema.Contact.PNUMBER, "624-901-4624");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Trixi Parmer");
        cv.put(DBSchema.Contact.PNUMBER, "251-683-2270");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Yasmeen Mcwhinney");
        cv.put(DBSchema.Contact.PNUMBER, "904-847-3468");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Webb Benzing");
        cv.put(DBSchema.Contact.PNUMBER, "534-176-3711");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Ross Ratazzi");
        cv.put(DBSchema.Contact.PNUMBER, "915-761-4481");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Biddie Wikey");
        cv.put(DBSchema.Contact.PNUMBER, "908-342-6005");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Lucy Donnison");
        cv.put(DBSchema.Contact.PNUMBER, "769-688-8214");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Eyde Spilsbury");
        cv.put(DBSchema.Contact.PNUMBER, "820-243-0460");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Ermengarde Arons");
        cv.put(DBSchema.Contact.PNUMBER, "465-567-6498");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Nancy Kropach");
        cv.put(DBSchema.Contact.PNUMBER, "999-511-8401");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Jackie Claypoole");
        cv.put(DBSchema.Contact.PNUMBER, "430-513-3925");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Gloriana Chawkley");
        cv.put(DBSchema.Contact.PNUMBER, "730-268-0815");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Fifi Hessing");
        cv.put(DBSchema.Contact.PNUMBER, "442-937-6704");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Faustine Delamaine");
        cv.put(DBSchema.Contact.PNUMBER, "125-391-8307");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Andros Kinde");
        cv.put(DBSchema.Contact.PNUMBER, "827-399-8580");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Lincoln Vickerstaff");
        cv.put(DBSchema.Contact.PNUMBER, "240-659-4909");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Jonell Langsbury");
        cv.put(DBSchema.Contact.PNUMBER, "112-622-2063");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Bree Godbald");
        cv.put(DBSchema.Contact.PNUMBER, "956-926-0531");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Joseph Gear");
        cv.put(DBSchema.Contact.PNUMBER, "288-108-9745");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Aidan Notton");
        cv.put(DBSchema.Contact.PNUMBER, "963-154-9985");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Read Melsome");
        cv.put(DBSchema.Contact.PNUMBER, "844-655-3451");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Kiri Bearcroft");
        cv.put(DBSchema.Contact.PNUMBER, "622-211-6198");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Robbi Kernar");
        cv.put(DBSchema.Contact.PNUMBER, "437-251-9559");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Jenny Dufton");
        cv.put(DBSchema.Contact.PNUMBER, "711-648-3984");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Christian Oakinfold");
        cv.put(DBSchema.Contact.PNUMBER, "450-257-3494");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Banky Woollons");
        cv.put(DBSchema.Contact.PNUMBER, "402-531-4336");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Katrina Pigney");
        cv.put(DBSchema.Contact.PNUMBER, "452-375-4000");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Faunie Chaldecott");
        cv.put(DBSchema.Contact.PNUMBER, "176-791-8668");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Stinky Rowesby");
        cv.put(DBSchema.Contact.PNUMBER, "815-882-5594");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Nev Davidovitz");
        cv.put(DBSchema.Contact.PNUMBER, "985-225-3382");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Sergio Woollends");
        cv.put(DBSchema.Contact.PNUMBER, "370-364-5495");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Gwenny Cubberley");
        cv.put(DBSchema.Contact.PNUMBER, "243-195-3581");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Jermaine Ryves");
        cv.put(DBSchema.Contact.PNUMBER, "971-953-8015");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Alejandro Khidr");
        cv.put(DBSchema.Contact.PNUMBER, "342-581-3197");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Zondra Littleover");
        cv.put(DBSchema.Contact.PNUMBER, "390-103-9895");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Ferrell Nash");
        cv.put(DBSchema.Contact.PNUMBER, "211-951-1840");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Ruben Brimilcome");
        cv.put(DBSchema.Contact.PNUMBER, "552-886-9354");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Denney Caldaro");
        cv.put(DBSchema.Contact.PNUMBER, "738-164-2501");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Vivienne Dunklee");
        cv.put(DBSchema.Contact.PNUMBER, "282-397-1833");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Marty Merali");
        cv.put(DBSchema.Contact.PNUMBER, "116-965-6050");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Celene Rivett");
        cv.put(DBSchema.Contact.PNUMBER, "628-799-7490");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Carline Lere");
        cv.put(DBSchema.Contact.PNUMBER, "453-702-3859");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Alvy Charrette");
        cv.put(DBSchema.Contact.PNUMBER, "715-701-6743");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Marrilee Groneway");
        cv.put(DBSchema.Contact.PNUMBER, "812-242-7358");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Cornall Tulley");
        cv.put(DBSchema.Contact.PNUMBER, "491-942-9057");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Rolland Stirrup");
        cv.put(DBSchema.Contact.PNUMBER, "828-829-4306");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Jecho Curley");
        cv.put(DBSchema.Contact.PNUMBER, "984-950-6998");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Garrard Abbet");
        cv.put(DBSchema.Contact.PNUMBER, "347-483-2358");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Missie Juszkiewicz");
        cv.put(DBSchema.Contact.PNUMBER, "796-931-8131");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Albina Ommanney");
        cv.put(DBSchema.Contact.PNUMBER, "926-801-1719");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Pebrook Offield");
        cv.put(DBSchema.Contact.PNUMBER, "231-365-9719");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Cornie Dunwoody");
        cv.put(DBSchema.Contact.PNUMBER, "942-746-4636");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Jecho Ricardet");
        cv.put(DBSchema.Contact.PNUMBER, "692-456-6336");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Lissa Dahlbom");
        cv.put(DBSchema.Contact.PNUMBER, "933-195-9811");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Gonzales McKeating");
        cv.put(DBSchema.Contact.PNUMBER, "642-124-1132");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Brendin Domke");
        cv.put(DBSchema.Contact.PNUMBER, "501-656-9255");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Dredi Espy");
        cv.put(DBSchema.Contact.PNUMBER, "414-439-7512");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Ogdon Thridgould");
        cv.put(DBSchema.Contact.PNUMBER, "983-388-9432");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Rori Maud");
        cv.put(DBSchema.Contact.PNUMBER, "266-845-8162");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Laurent Sidnall");
        cv.put(DBSchema.Contact.PNUMBER, "508-934-8627");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Richmound Dober");
        cv.put(DBSchema.Contact.PNUMBER, "321-132-0384");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Ogdon Astlatt");
        cv.put(DBSchema.Contact.PNUMBER, "550-222-3327");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Beitris Rizzillo");
        cv.put(DBSchema.Contact.PNUMBER, "492-392-6361");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Selina Birdsey");
        cv.put(DBSchema.Contact.PNUMBER, "624-977-7171");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Lesly Conrath");
        cv.put(DBSchema.Contact.PNUMBER, "409-112-7918");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Zarah Prestage");
        cv.put(DBSchema.Contact.PNUMBER, "808-149-5872");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Hermon Sinclar");
        cv.put(DBSchema.Contact.PNUMBER, "363-782-7555");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Toby Samsonsen");
        cv.put(DBSchema.Contact.PNUMBER, "652-934-7855");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Mahmud Schachter");
        cv.put(DBSchema.Contact.PNUMBER, "353-616-7221");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Slade Meus");
        cv.put(DBSchema.Contact.PNUMBER, "284-761-9561");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Marleah Wright");
        cv.put(DBSchema.Contact.PNUMBER, "406-327-8500");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Jon Morrowe");
        cv.put(DBSchema.Contact.PNUMBER, "882-693-6827");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Shaw Guiett");
        cv.put(DBSchema.Contact.PNUMBER, "288-707-8646");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Jamie Waggatt");
        cv.put(DBSchema.Contact.PNUMBER, "735-481-2481");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Shadow Dredge");
        cv.put(DBSchema.Contact.PNUMBER, "796-663-3055");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Fenelia Letch");
        cv.put(DBSchema.Contact.PNUMBER, "765-912-8209");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Robby Marchbank");
        cv.put(DBSchema.Contact.PNUMBER, "930-401-5424");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Jewel Claasen");
        cv.put(DBSchema.Contact.PNUMBER, "433-946-3494");
        values.add(cv);

        cv = new ContentValues();
        cv.put(DBSchema.Contact.NAME, "Noreen Kas");
        cv.put(DBSchema.Contact.PNUMBER, "200-921-9840");
        values.add(cv);*/

        try{
            db.beginTransaction();
            db.delete(DBSchema.Person.TABLENAME, null, null);
            for (ContentValues value: values){
                db.insert(DBSchema.Person.TABLENAME, null, value);
            }
            db.setTransactionSuccessful();
        }catch (SQLException e){
            Log.e("DummyDataException", e.getMessage());
        }finally {
            db.endTransaction();
        }


    }

}
