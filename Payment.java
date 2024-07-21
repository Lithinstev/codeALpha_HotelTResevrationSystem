class Payment {
    private int paymentId;
    private int reservationId;
    private double amount;
    private boolean isPaid;

    public Payment(int paymentId, int reservationId, double amount) {
        this.paymentId = paymentId;
        this.reservationId = reservationId;
        this.amount = amount;
        this.isPaid = false;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public int getReservationId() {
        return reservationId;
    }

    public double getAmount() {
        return amount;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId=" + paymentId +
                ", reservationId=" + reservationId +
                ", amount=" + amount +
                ", isPaid=" + isPaid +
                '}';
    }
}

