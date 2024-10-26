import java.time.LocalDateTime;

// The default, no-argument constructor will simply set all members to their default values.

class DefaultConstructorFields {
	String name;
    LocalDateTime date;
    double number;
	
	@Override
    public String toString() {
        return this.name + " " + this.date.toString() + " "+this.number;
    }
	
	public static void main(String args[]) {
		new DefaultConstructorFields();	
	}	
}

// No Output or Empty Output or Blank Output