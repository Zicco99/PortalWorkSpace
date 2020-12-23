import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.MapType;

import org.apache.commons.io.FileUtils;

public class Portal {
    HashMap<String, String> map;
    ObjectMapper objectMapper;
    MapType type;
    File database;
    Scanner s;
    String parallel;
    File temp;
    String root_temp;
    int setupmode=0;

    public Portal() {
        objectMapper = new ObjectMapper();
        type = (objectMapper.getTypeFactory()).constructMapType(HashMap.class, String.class, String.class);
    }

    public int DBload() {
        database = new File("./DB.json");
        try {
            if (database.exists()) {
                map = objectMapper.readValue(database, type);
            } else {
                map = new HashMap<String,String>();
                database.createNewFile();
                Scanner s = new Scanner(System.in);
                //First setup:
                System.out.println("First configuration:");

                System.out.println("Gimme desktop path: [ex. /home/chilledpanda/Scrivania] ");
                map.put("desktop",s.nextLine());

                System.out.println("Gimme the folder's path where you'll put parallel desktops : [ex. /home/chilledpanda/Documenti]");
                parallel = s.nextLine();
                map.put("parallels",parallel);

                String def_path = parallel + "/def";
                File defaultDesk = new File(def_path);
                if (!defaultDesk.exists()){
                    defaultDesk.mkdirs();
                }

                map.put("def",def_path);
                map.put("lastmoved", "def");

                objectMapper.writeValue(database, map);
                s.close();
                setupmode=1;
            }
        } catch (IOException e) {
            setupmode=0;
            database.delete();
            System.out.print("Error in the creating / loading DB phase");
            e.printStackTrace();
        }
        return setupmode;
    }

    public void dir2dir(String src, String dest) {
        File srcDir = new File(src);
        File destDir = new File(dest);

        try {
            if(srcDir.exists()){
            //cancello i vecchi file del workspace
            FileUtils.deleteDirectory(destDir);
            if (!destDir.exists()){
                destDir.mkdirs();
            }
            FileUtils.copyDirectory(srcDir, destDir);
            }else throw new IOException();
        } catch (IOException e ) {
            System.out.println("This workspace does not exists");
        }

    }

    public HashMap<String, String> get(){
        return map;
    }

    public String get_par(){
        return parallel;
    }

	public void update_db(HashMap<String, String> map2) {
        try {
            objectMapper.writeValue(database, map);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
