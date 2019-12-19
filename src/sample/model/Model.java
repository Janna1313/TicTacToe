package sample.model;

import java.io.*;
import java.util.ArrayList;

public class Model {

    final int size;
    int[][] grid;

    public Model(int size){
        this.size = size;
        generateField(size);
    }

    public Boolean makeTurn(int x, int y, int player) {
        setField(x, y, player);
        return ready(player);
    }

    private Boolean ready(int player){
        if (checkRows(player)){
            return true;
        }
        if (checkDraw()){
            return null;
        }
        return false;
    };

    private void setField(int x, int y, int player) {
        grid[x][y] = player;
    }

    private void generateField(int size) {
        grid = new int[size][size];
        for (int x = 0; x < size; x++){
            for(int y = 0; y < size; y++){
                grid[x][y] = 0;
            }
        }
    }

    public void restart(){
        grid = null;
        generateField(size);
    }

    private boolean checkRows(int player){
        for (int i = 0; i < 2; i++) {
            for (int x = 0; x < size; x++) {
                int y = 0;
                if (checkRow(x,y,i,player)){
                    return true;
                }
            }
        }
        if (checkRow(0,0,2,player)){
            return true;
        }
        if (checkRow(0,0,3,player)){
            return true;
        }
        return false;
    };

    private boolean checkRow(int x, int y, int mode, int player){
        boolean correctPlayer = true;
        while (correctPlayer) {
            if (mode == 0) {correctPlayer = checkField(x, y, player);}
            if (mode == 1) {correctPlayer = checkField(y, x, player);}
            if (mode == 2) {correctPlayer = checkField(y, y, player);}
            if (mode == 3) {correctPlayer = checkField(y, size-y-1, player);}
            if (correctPlayer){y++;}
            if (y == size) {
            return true;
            }
        }
        return false;
    };

    private boolean checkField(int x, int y, int player) {
        if (grid[x][y] == player){
            return true;
        }
        return false;
    };

    private boolean checkDraw(){
        for (int x = 0; x < size; x++){
            for(int y = 0; y < size; y++){
                if (grid[x][y] == 0){
                    return false;
                }
            }
        }
        return true;
    };

    public static ArrayList<String> getScoreBord(){
        ArrayList<String> scoreBord = new ArrayList<String>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("ScoreBord.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                scoreBord.add(line);
            }
            br.close();
        }catch (IOException cannotRead) {
            System.out.println("A problem while loading the scorebord occurred.");
        }
        return scoreBord;
    };

    public void saveWin(String name){
        ArrayList<String> scoreBord = getScoreBord();
        Boolean found = false;
        if (scoreBord != null){
            for(String entry : scoreBord){
                String[] parts = entry.split(" ");
                if(parts[1].equals(name)){
                    int score = Integer.parseInt(parts[0]) + 1;
                    scoreBord.set(scoreBord.indexOf(entry),score + " " + name);
                    found = true;
                }
            }
        }
        if(!found){
            scoreBord.add(1 + " " + name);
        }

        ArrayList<Entry> entrys = new ArrayList<Entry>();
        for(String entry : scoreBord){
            String[] parts = entry.split(" ");
            entrys.add(new Entry(parts[1], Integer.parseInt(parts[0])));
        }

        entrys = sortEntrys(entrys);

        String save = "";
        for(String entry : scoreBord){
            save += entry + System.lineSeparator();
        }
        try {
            FileWriter writer = new FileWriter("ScoreBord.txt");
            writer.write(save);
            writer.close();
        }catch (IOException cannotRead) {
            System.out.println("A problem while saving the scorebord occurred.");
        }
    }

    private ArrayList<Entry> sortEntrys(ArrayList<Entry> entrys)
    {
        int n = entrys.size();
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (entrys.get(j).getCount() > entrys.get(j+1).getCount() )
                {
                    // swap temp and arr[i]
                    int temp = entrys.get(j).getCount();
                    entrys.get(j).setCount(entrys.get(j+1).getCount());
                    entrys.get(j+1).setCount(temp);
                }
        return entrys;
    }
}