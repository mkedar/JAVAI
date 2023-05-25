public abstract class Name {
    private String m_name;

    public Name(String name) {
        m_name = name;
    }

    public String getName() {
        return m_name;
    }

    public String toString() {
        return "USERNAME(" + m_name + ")";
    }

    public abstract boolean match(String search);

    public abstract boolean isTheSame(Name another);
}

