package App;

public class Group {
    private int groupId;
    public int length=1;
    private int filledUpTo;
    protected Student[] students = new Student[1];

    public Group(int groupId) {
        this.groupId = groupId;
        this.filledUpTo = 0;
        this.ChangeArrayLength(10);
    }

    public void ChangeArrayLength(int newlength){
        Student[] newstudents = new Student[newlength];

        for (int i = 0; i<length; i++) {
        newstudents[i]=students[i];
        }
        for (int i = students.length; i<newlength; i++) {
            newstudents[i] = new Student ();
        }
        students = newstudents;
        this.length = students.length;
    }

    public void Add (String name, String surname){
        if (length>filledUpTo) {
            students[filledUpTo+1] = new Student (name, surname, groupId);
            filledUpTo++;
        } else { ChangeArrayLength(length+1);
        this.Add(name, surname); }
    }

    public String StudentToString(int studentindex){
        if (this.students[studentindex].getGroup() != 0) {
            return students[studentindex].toString();
        } else return "";
    }

    public int FilledUpTo(){
        return this.filledUpTo;
    }

    public int IdShow(){
        return this.groupId;
    }

    public void StudentDelete(int studentnumber) {
        this.students[studentnumber] = null;
        for (int i=0; i<students.length-1; i++){
            if (students[i].getGroup() == 0){
                students[i] = students[i+1];
                students[i+1].group = 0;
            } students[length-1] = students[length];
            students[length].group = 0;
        }
        for (int i =0; i<students.length; i++){
            if (students[i].getGroup() == 0) {
                ChangeArrayLength(i-1);
            }
        }
    }

    public String Find(String searcheablesurname) {
        for (int i =0; i<=this.filledUpTo; i++) {
            if (students[i].getSurname().equals(searcheablesurname)) {
                return students[i].toString();
            }
        }
        return "";
    }

    public void GvoupClear() {
        for (int i=0; i<students.length; i++){
            students[i]=null;
            }
        ChangeArrayLength(10);
        length=0;
        filledUpTo=0;

    }

}
