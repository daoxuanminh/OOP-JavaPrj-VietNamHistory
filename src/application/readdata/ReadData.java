package application.readdata;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import objects.figure.Figure;

public class ReadData<T> {

    public ObservableList<T> FromJsonToArray(String filePath, Class<T> objectType) throws IOException {
        // String carInfoJson = new String(Files.readAllBytes(Paths.get(filePath)));
        Gson gson = new Gson();
        List<T> objects = null;
        Type listType = TypeToken.getParameterized(List.class, objectType).getType();
        objects = gson.fromJson(new FileReader(filePath), listType);
        ObservableList<T> result = FXCollections.observableList(objects);
        return result;
    }
    
    public static void main(String[] args) throws IOException {
        ReadData<Figure> reader = new ReadData<Figure>();
        ObservableList<Figure> list = reader.FromJsonToArray("src/data/figureUpdate.json", Figure.class);
        System.out.println(list);
    }
}
