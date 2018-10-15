package hello;

/**
 * The Class HelloMessage.
 */
public class HelloMessage {

	private String name;
	
	private String flight;
	
	private String session;

	/**
	 * Instantiates a new hello message.
	 */
	public HelloMessage() {
	}

	/**
	 * Instantiates a new hello message.
	 *
	 * @param name the name
	 * @param flight the flight
	 */
	public HelloMessage(String name, String flight, String session) {
		this.name = name;
		this.flight = flight;
		this.setSession(session);
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the flight.
	 *
	 * @return the flight
	 */
	public String getFlight() {
		return flight;
	}

	/**
	 * Sets the flight.
	 *
	 * @param flight the new flight
	 */
	public void setFlight(String flight) {
		this.flight = flight;
	}

	public String getSession() {
		return session;
	}

	public void setSession(String session) {
		this.session = session;
	}
}
