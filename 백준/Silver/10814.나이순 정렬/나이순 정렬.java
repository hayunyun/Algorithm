import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static class Person implements Comparable<Person>  {
        int age, idx;
        String name;

        public Person(int _age, String _name, int _idx) {
            this.age = _age;
            this.name = _name;
            this.idx = _idx;
        }

        @Override
        public int compareTo(Person o) {
            if (this.idx == o.idx)
                return this.idx - o.idx;
            return this.age - o.age;
        }

        @Override
        public String toString() {
            return this.age + " " + this.name;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));  
        
        int N = Integer.parseInt(br.readLine());
        Person[] people = new Person[N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            people[i] = (new Person(age, name, i));
        }
        Arrays.sort(people);

        for (Person person : people)
            bw.write(person + "\n");

        bw.flush();
        bw.close();
    }
}