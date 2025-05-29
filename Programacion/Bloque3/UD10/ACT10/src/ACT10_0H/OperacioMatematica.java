package ACT10_0H;

// Definició de l'enum OperacioMatematica
public enum OperacioMatematica {
    // Enum constantes con implementaciones específicas
    SUMA {
        @Override
        public double executa(double x, double y) {
            return x + y;
        }

        @Override
        public String toString() {
            return "Suma";
        }
    },
    RESTA {
        @Override
        public double executa(double x, double y) {
            return x - y;
        }

        @Override
        public String toString() {
            return "Resta";
        }
    },
    MULTIPLICACIO {
        @Override
        public double executa(double x, double y) {
            return x * y;
        }

        @Override
        public String toString() {
            return "Multiplicació";
        }
    },
    DIVISIO {
        @Override
        public double executa(double x, double y) {
            if (y != 0) {
                return x / y;
            } else {
                throw new ArithmeticException("No es possible dividir per zero");
            }
        }

        @Override
        public String toString() {
            return "Divisió";
        }
    };

    // Método abstracto que cada constante debe implementar
    public abstract double executa(double x, double y);
}