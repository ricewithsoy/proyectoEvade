package com.example.proyectoevade;

public class Imagen {

        private String nombre;
        private int idDrawable;

        public Imagen(String nombre, int idDrawable) {
            this.nombre = nombre;
            this.idDrawable = idDrawable;
        }

        public String getNombre() {
            return nombre;
        }

        public int getIdDrawable() {
            return idDrawable;
        }

        public int getId() {
            return nombre.hashCode();
        }

        public static Imagen[] ITEMS = {
                new Imagen("Evade 01", R.drawable.img1),
                new Imagen("Evade 02", R.drawable.img2),
                new Imagen("Evade 03", R.drawable.img3),
                new Imagen("Evade 04", R.drawable.img6),
                new Imagen("Evade 05", R.drawable.img7),
                new Imagen("Evade 06", R.drawable.img8),
                new Imagen("Evade 07", R.drawable.img9),
                new Imagen("Evade 08", R.drawable.img10),
                new Imagen("Evade 09", R.drawable.img11),
                new Imagen("Evade 10", R.drawable.img12),
        };

        /**
         * Obtiene item basado en su identificador
         *
         * @param id identificador
         * @return Imagen
         */
        public static Imagen getItem(int id) {
            for (Imagen item : ITEMS) {
                if (item.getId() == id) {
                    return item;
                }
            }
            return null;
        }
    }

