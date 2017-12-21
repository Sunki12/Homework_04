package search.impl;

import search.FileHandler;
import vo.Program;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileHandlerImpl implements FileHandler {
    @Override
    public int program2File(List<Program> programList) {
        StringBuilder line = new StringBuilder("");
        for(Program program:programList){
            String id = program.getId();
            String university = program.getUniversity();
            String country = program.getCountry();
            String programName = program.getProgramName();
            String school = program.getSchool();
            String degree = program.getDegree();
            String email = program.getEmail();
            String phone = program.getPhoneNumber();
            String location = program.getLocation();
            String deadlineWithAid = program.getDeadlineWithAid();
            String deadlineWithoutAid = program.getDeadlineWithoutAid();
            String homepage = program.getHomepage();
            line.append(id+ "\t"+university +"\t"+ country + "\t" +programName + "\t" +school + "\t"
                    +degree + "\t" +email + "\t" +phone + "\t" +location + "\t" +deadlineWithAid + "\t" +deadlineWithoutAid + "\t" +homepage + "\n");
        }
        try
        {
            File file = new File("C:\\Users\\35200\\Desktop\\hm4\\target\\University of Copenhagen.txt");
            if(! file.exists()) {
                file.createNewFile();
            }
            BufferedWriter br = new BufferedWriter(new FileWriter(file));
            br.write(line.toString());
            br.close();
        }
        catch (IOException e) {e.printStackTrace();}

        return 0;
    }
}
