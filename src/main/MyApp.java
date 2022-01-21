package main;

import javax.swing.JOptionPane;

import persistence.Deserialization;
import views.MainFrame;

public class MyApp {
	
	/*private static List<Address> addresses;
	private static List<Student> students;
	private static List<Professor> professors;
	private static List<Subject> subjects;
	private static List<Department> departments;*/

	public static void main(String[] args) {
		if(!Deserialization.run()) {
			JOptionPane.showMessageDialog(null, "Ucitavanje podataka neuspesno!");
			return;
		}
		MainFrame.getInstance();
		
		
		/*addresses =  loadAddress();
		students = loadStudents();
		professors = loadProfessors();
		subjects = loadSubjects();
		nepolozeni();
		ocene();
		departments = loadDepartments();
		Database.getInstance().getStudentDatabase().set(students);
		Database.getInstance().getProfessorDatabase().set(professors);
		Database.getInstance().getSubjectDatabase().set(subjects);
		Database.getInstance().getDepartmentDatabase().set(departments);
		Serialization.run();*/
	}
	
	
	/* DATA SEED
	private static List<Department> loadDepartments() {
		List<Department> departments = new LinkedList<>();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("katedre.csv"),"UTF8"));) {

            String str;
            br.readLine();
            while ((str = br.readLine()) != null) {
            	String[] data = str.split(",");
                int idd = Integer.parseInt(data[0]);
                String id = data[1];
                String name = data[2];
                Professor manager = findProfessor(Integer.parseInt(data[3]));
                Department d = new Department(id, name, manager);
                for (Professor p : professors) {
                	if (p.getId_katedra() == idd)
                		d.getProfessors().add(p);
                }
                departments.add(d);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
		return departments;
	}
	
	private static void ocene() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("ocene.csv"),"UTF8"));) {

            String str;
            br.readLine();
            while ((str = br.readLine()) != null) {
            	String[] data = str.split(",");
                Student s = findStudent(Integer.parseInt(data[0]));
                Subject ss = findSubject(Integer.parseInt(data[1]));
                int ocena = Integer.parseInt(data[2]);
                Date date = null;
                try {
					date = ValidationPatterns.dateFormat.parse(data[3]);
				} catch (ParseException e) {
					e.printStackTrace();
				}
                s.getPassedExams().add(new ExamGrade(
                		s,
                		ss,
                		ocena,
                		date));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	private static void nepolozeni() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("nepolozeni.csv"),"UTF8"));) {

            String str;
            br.readLine();
            while ((str = br.readLine()) != null) {
            	String[] data = str.split(",");
                int ids = Integer.parseInt(data[0]);
                int idp = Integer.parseInt(data[1]);
                Student s = findStudent(ids);
                Subject p = findSubject(idp);
                s.getNotPassedExams().add(p);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	private static Subject findSubject(int id) {
		for (Subject s : subjects) {
			if (s.getIdd() == id)
				return s;
		}
		return null;
	}
	
	private static List<Subject> loadSubjects() {
		List<Subject> subjects = new LinkedList<>();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("predmeti.csv"),"UTF8"));) {

            String str;
            br.readLine();
            while ((str = br.readLine()) != null) {
            	String[] data = str.split(",");
                int idd = Integer.parseInt(data[0]);
                String id = data[1];
                String name = data[2];
                int year = Integer.parseInt(data[3]);
                int esbp = Integer.parseInt(data[4]);
                Professor p = null;
                if (data[5].compareTo("null") != 0)
                	p = findProfessor(Integer.parseInt(data[5]));
                Semester semestar = Semester.valueOf(data[6]);
                subjects.add(new Subject(
                		idd,
                		id,
                		name,
                		semestar,
                		year,
                		esbp,
                		p));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
		return subjects;
	}
	
	private static Professor findProfessor(int id) {
		for (Professor p : professors) {
			if (p.getId() == id)
				return p;
		}
		return null;
	}
	
	private static List<Professor> loadProfessors() {
		List<Professor> professors = new LinkedList<>();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("profesori.csv"),"UTF8"));) {

            String str;
            br.readLine();
            while ((str = br.readLine()) != null) {
            	String[] data = str.split(",");
            	int id;
            	try {
            		id = Integer.parseInt(data[0]);
            	}
            	catch(Exception e) {
            		break;
            	}
                int idCardNumber = Integer.parseInt(data[1]);
                String fName = data[2];
                String lName = data[3];
                Date date = null;
                try {
					date = ValidationPatterns.dateFormat.parse(data[4]);
				} catch (ParseException e) {
					e.printStackTrace();
				}
                Address a1 = getAddress(Integer.parseInt(data[5]));
                String phoneNumber = data[6];
                String email = data[7];
                Address a2 = getAddress(Integer.parseInt(data[8]));
                int staz = Integer.parseInt(data[9]);
                Title title = Title.valueOf(data[10]);
                int id_katedra = Integer.parseInt(data[11]);
                professors.add(new Professor(
                		id,
                		id_katedra,
                		fName,
                		lName,
                		date,
                		a1,
                		phoneNumber,
                		email,
                		a2,
                		idCardNumber,
                		title,
                		staz));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
		return professors;
	}
	
	private static List<Address> loadAddress() {
		List<Address> address = new LinkedList<>();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("adrese.csv"),"UTF8"));) {

            String str;
            br.readLine();
            while ((str = br.readLine()) != null) {
            	String[] data = str.split(",");
                address.add(new Address(
                		Integer.parseInt(data[0]),
                		data[1],
                		data[2],
                		data[3],
                		data[4]
                		));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
		return address;
	}
	
	private static Student findStudent(int id) {
		for (Student s : students) {
			if (s.getId() == id)
				return s;
		}
		return null;
	}
	
	private static List<Student> loadStudents() {
		List<Student> students = new LinkedList<>();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("studenti.csv"),"UTF8"));) {

            String str;
            br.readLine();
            while ((str = br.readLine()) != null) {
            	String[] data = str.split(",");
            	int id = Integer.parseInt(data[0]);
            	String index = data[1];
            	String firstName = data[2];
            	String lastName = data[3];
            	int currentYear = Integer.parseInt(data[4]);
            	Date date = null;
            	try {
					date = ValidationPatterns.dateFormat.parse(data[5]);
				} catch (ParseException e) {
					e.printStackTrace();
				}
            	Address a = null;
            	if (data[6].compareTo("null") != 0)
            		a = getAddress(Integer.parseInt(data[6]));
            	String phoneNumber = data[7];
            	String email = data[8];
            	Status status = Status.valueOf(data[9]);
            	int enrollmentYear = Integer.parseInt(data[10]);
            	students.add(new Student(
            			id,
            			firstName,
            			lastName,
            			date,
            			a,
            			phoneNumber,
            			email,
            			index,
            			enrollmentYear,
            			currentYear,
            			status,
            			0));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
		return students;
	}
	
	private static Address getAddress(int id) {
		for (Address a : addresses) {
			if (a.getId() == id) {
				return new Address(
						a.getStreet(),
						a.getHouseNumber(),
						a.getCity(),
						a.getCountry());
			}
		}
		return null;
	}
*/
}
