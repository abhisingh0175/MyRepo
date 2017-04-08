package miscellaneous;

public class Emp {
int id;
String name;
boolean active;
long sal;
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + (active ? 1231 : 1237);
	result = prime * result + id;
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	result = prime * result + (int) (sal ^ (sal >>> 32));
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Emp other = (Emp) obj;
	if (active != other.active)
		return false;
	if (id != other.id)
		return false;
	if (name == null) {
		if (other.name != null)
			return false;
	} else if (!name.equals(other.name))
		return false;
	if (sal != other.sal)
		return false;
	return true;
}


}
