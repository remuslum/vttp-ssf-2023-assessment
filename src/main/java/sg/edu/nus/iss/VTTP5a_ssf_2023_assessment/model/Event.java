package sg.edu.nus.iss.VTTP5a_ssf_2023_assessment.model;



import jakarta.json.Json;
import jakarta.json.JsonObject;

public class Event {

    private Integer eventId;
    private String eventName;
    private Integer eventSize;
    private Long eventDate;
    private Integer participants;

    public Event() {

    }

    public Event(Integer eventId, String eventName, Integer eventSize, Long eventDate, Integer participants) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.eventSize = eventSize;
        this.eventDate = eventDate;
        this.participants = participants;
    }

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Integer getEventSize() {
        return eventSize;
    }

    public void setEventSize(Integer eventSize) {
        this.eventSize = eventSize;
    }

    public Long getEventDate() {
        return eventDate;
    }

    public void setEventDate(Long eventDate) {
        this.eventDate = eventDate;
    }

    public Integer getParticipants() {
        return participants;
    }

    public void setParticipants(Integer participants) {
        this.participants = participants;
    }

    public String convertToJSONString(){
        JsonObject jsonObject = Json.createObjectBuilder().add("eventId",this.eventId)
        .add("eventName", this.eventName).add("eventSize",this.eventSize)
        .add("eventDate",eventDate).add("participants",this.participants).build();
        return jsonObject.toString();
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        String separator = ",";
        sb.append(String.valueOf(this.eventId)).append(separator).append(this.eventName).append(separator)
        .append(String.valueOf(this.eventSize)).append(separator).append(String.valueOf(this.eventDate))
        .append(this.participants);
        return sb.toString();
    }

}
