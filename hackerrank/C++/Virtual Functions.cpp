class Person{
    public:
        virtual void getdata(){
            cin >> name;
            cin >> age;
        }
    
        virtual void putdata(){
            cout << name << " ";
            cout << age << " ";
        }
    
    protected:
        string name;
        int age;
};

class Professor: public Person{
    public:
        Professor(){
            cur_id++;
            id = cur_id;
        }
    
        void getdata(){
            Person::getdata();
            cin >> publications;
        }
    
        void putdata(){
            Person::putdata();
            cout << publications << " ";
            cout << id << endl;
        }
    
    private:
        string publications;
        static long cur_id;
        long id;
};

long Professor::cur_id = 0;

class Student: public Person{
    public:
        Student(): max_marks(6){
            cur_id++;
            id = cur_id;
        }
    
        void getdata(){
            Person::getdata();
            for(int i=0; i < max_marks; i++){
                cin >> marks[i];
            }
        }
    
        void putdata(){
            Person::putdata();
            long sum = 0;
            for(int i=0; i < max_marks; i++){
                sum += marks[i];
            }
            cout << sum << " ";
            cout << id << endl;
        }
    
    private:
    int marks[6];
    static long cur_id;
    const int max_marks;
    long id;
};

long Student::cur_id = 0;
