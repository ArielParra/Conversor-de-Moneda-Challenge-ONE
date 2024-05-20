public record Moneda(float conversion) {
    @Override
    public String toString() {
        return this.conversion +"";
    }
}