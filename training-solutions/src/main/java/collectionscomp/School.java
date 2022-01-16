package collectionscomp;

import java.text.Collator;
import java.text.ParseException;
import java.text.RuleBasedCollator;
import java.util.*;

public class School {

    public static void main(String[] args) {
        Set<Student> students = new TreeSet<>(new StudentComparator());

        Student firstStudent = new Student("Pál Liliána", 145);
        Student secondStudent = new Student("Ókovács Előd", 135);
        Student thirdStudent = new Student("Érdemes Júlia", 185);
        Student fourthStudent = new Student("Árvai Gábor", 140);
        Student fifthStudent = new Student("Patai Gabriella", 190);
        students.add(firstStudent);
        students.add(secondStudent);
        students.add(thirdStudent);
        students.add(fourthStudent);
        students.add(fifthStudent);

        System.out.println(students);

        String hunRule = "< a,A < á,Á < b,B < c,C < cs,Cs,CS < d,D < dz,Dz,DZ < dzs,Dzs,DZS < e,E < é,É < f,F < g,G < gy,Gy,GY < h,H < i,I < í,Í" +
                "< j,J < k,K < l,L < ly,Ly,LY < m,M < n,N < ny,Ny,NY < o,O < ó,Ó < ö,Ö < ő,Ő < p,P < q,Q < r,R < s,S < sz,Sz,SZ < t,T < ty,Ty,TY" +
                "< u,U < ú,Ú < ü,Ü < ű,Ű < v,V < w,W < x,X < y,Y < z,Z < zs,Zs,ZS";
        Collator collator = Collator.getInstance(new Locale("hu", "HU"));
        try {
            collator = new RuleBasedCollator(hunRule);
        } catch (ParseException p) {
            System.out.println("Invalid rule!");
        }
        Map<String, Integer> studentMap = new TreeMap<>(collator);
        studentMap.put(firstStudent.getName(), firstStudent.getHeight());
        studentMap.put(secondStudent.getName(), secondStudent.getHeight());
        studentMap.put(thirdStudent.getName(), thirdStudent.getHeight());
        studentMap.put(fourthStudent.getName(), fourthStudent.getHeight());
        studentMap.put(fifthStudent.getName(), fifthStudent.getHeight());

        System.out.println(studentMap);
    }
}
