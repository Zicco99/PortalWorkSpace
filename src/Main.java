import java.util.HashMap;

public class Main {
	public static void main(String[] args) {
		Portal p = new Portal();
		Integer f_execution = p.DBload();

		if (f_execution != 1) {
			HashMap<String, String> map = p.get();
			String path = map.get(args[0]);

			if (path == null) {
				path = map.get("parallels") + "/" + args[0];
				map.put(args[0], path);
				p.update_db(map);
			}

			String path2 = map.get(map.get("lastmoved"));

			p.dir2dir(map.get("desktop"), path2);
			p.dir2dir(path, map.get("desktop"));
			// Mi salvo qual'è dei workspace l'attuale desktop
			map.replace("lastmoved", args[0]);
			p.update_db(map);
		}
		else System.out.println("Setting done");

	}

}
