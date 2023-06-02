import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public class Proxy {
    public void serializeToJsonFile(String filename, ArrayList<DisplayObject> allObj, Settings settings, Players players) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode root = mapper.createObjectNode();

        ObjectNode settingsNode = mapper.valueToTree(settings);
        root.set("settings", settingsNode);

        ObjectNode playersNode = mapper.valueToTree(players.players[0].stat);
        root.set("players", playersNode);

        ArrayNode objectsNode = root.putArray("objects");
        for (DisplayObject object : allObj) {
            ObjectNode objectNode = mapper.valueToTree(object);
            objectsNode.add(objectNode);
        }
        try {
            File file = new File(filename);
            mapper.writeValue(file, root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void deserializeFromJsonFile(String filename, AllObjects allObj,Settings settings,Players players) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode rootNode = mapper.readTree(new File(filename));

            settings.fromJson(rootNode);

            players.fromJson(rootNode);

            allObj.fromJson(rootNode);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void serializeField(String filename, Object obj)  {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename, true))) {
            writer.println(obj.getClass().getName());
            for (Field field : obj.getClass().getDeclaredFields()) {
                if (!Modifier.isTransient(field.getModifiers())) {
                    field.setAccessible(true);
                    Object value = field.get(obj);
                    writer.println(field.getName() + ";" + value);
                }
            }
            for (Field field : obj.getClass().getSuperclass().getDeclaredFields()) {
                field.setAccessible(true);
                Object value = field.get(obj);
                writer.println(field.getName() + ";" + value);
            }
        } catch (IOException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    public void serializeToTextFile(String filename, ArrayList<DisplayObject> allObj, Settings settings, Players players) throws IOException {
        try {
            FileWriter writer = new FileWriter(filename);
            writer.write("");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (DisplayObject obj: allObj)
        {
            serializeField(filename,obj);
        }
        serializeField(filename,settings);
        serializeField(filename,players.players[0].stat);
    }
    public void deserializeFromTextFile(String filename, AllObjects allObjects,Settings settings, Players player) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            ArrayList<DisplayObject> figures = null;
            while (true) {
                String className = reader.readLine();
                if (className == null) break;
                Class<?> clazz = Class.forName(className);
                if (!className.equals("Settings") && !className.equals(("Player"))) {
                    DisplayObject figure = (DisplayObject) clazz.newInstance();
                    Field[] fields = figure.getClass().getDeclaredFields();
                    for (Field field : fields) {
                        if (!Modifier.isTransient(field.getModifiers())) {
                            String value = reader.readLine().split(";")[1];
                            Class<?> fieldType = field.getType();
                            Object convertedValue = null;

                            if (fieldType == int.class || fieldType == Integer.class) {
                                convertedValue = Integer.parseInt(value);
                            } else if (fieldType == double.class || fieldType == Double.class) {
                                convertedValue = Double.parseDouble(value);
                            } else if (fieldType == boolean.class || fieldType == Boolean.class) {
                                convertedValue = Boolean.parseBoolean(value);
                            }
                            field.setAccessible(true);
                            field.set(figure, convertedValue);
                        }
                    }
                    fields = figure.getClass().getSuperclass().getDeclaredFields();
                    for (Field field : fields) {
                        String value = reader.readLine().split(";")[1];
                        Class<?> fieldType = field.getType();
                        Object convertedValue = null;

                        if (fieldType == int.class || fieldType == Integer.class) {
                            convertedValue = Integer.parseInt(value);
                        } else if (fieldType == double.class || fieldType == Double.class) {
                            convertedValue = Double.parseDouble(value);
                        } else if (fieldType == boolean.class || fieldType == Boolean.class) {
                            convertedValue = Boolean.parseBoolean(value);
                        }
                        field.setAccessible(true);
                        field.set(figure, convertedValue);
                    }
                    figures.add(figure);
                } else if(!className.equals("Settings")){
                    Settings figure = (Settings) clazz.newInstance();
                    Field[] fields = figure.getClass().getDeclaredFields();
                    for (Field field : fields) {
                        if (!Modifier.isTransient(field.getModifiers())) {
                            String value = reader.readLine().split(";")[1];
                            Class<?> fieldType = field.getType();
                            Object convertedValue = null;

                            if (fieldType == int.class || fieldType == Integer.class) {
                                convertedValue = Integer.parseInt(value);
                            } else if (fieldType == double.class || fieldType == Double.class) {
                                convertedValue = Double.parseDouble(value);
                            } else if (fieldType == boolean.class || fieldType == Boolean.class) {
                                convertedValue = Boolean.parseBoolean(value);
                            }
                            field.setAccessible(true);
                            field.set(figure, convertedValue);
                        }
                    }
                    settings = figure;
                }
            }
        } catch (IOException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
