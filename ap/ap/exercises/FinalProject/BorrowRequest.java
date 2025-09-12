package ap.exercises.FinalProject;

import java.time.LocalDate;

public class BorrowRequest {
    private String requestId;
    private String studentId;
    private String bookId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;

    public BorrowRequest(String requestId, String studentId, String bookId, LocalDate startDate, LocalDate endDate) {
        this.requestId = requestId;
        this.studentId = studentId;
        this.bookId = bookId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = "PENDING";
    }

    public String getRequestId() { return requestId; }
    public String getStudentId() { return studentId; }
    public String getBookId() { return bookId; }
    public LocalDate getStartDate() { return startDate; }
    public LocalDate getEndDate() { return endDate; }
    public String getStatus() { return status; }

    public void setStatus(String status) {
        if (status != null && (status.equals("PENDING") || status.equals("APPROVED") || status.equals("REJECTED"))) {
            this.status = status;
        }
    }

    @Override
    public String toString() {
        return "Request ID: " + requestId + ", Student ID: " + studentId +
                ", Book ID: " + bookId + ", Period: " + startDate + " to " + endDate +
                ", Status: " + status;
    }
}