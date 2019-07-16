package com.example.felizmarket.model;

import java.util.ArrayList;


public class ProductsResponse {
    private final int id;

    private final String name;

    private final String enName;

    private final String image;

    private final String subCat;

    private final String createdAt;

    private final String updatedAt;

    private final Object deletedAt;


    private final ArrayList<Items> items;

    public ProductsResponse(int id, String name, String enName, String image, String subCat,
                            String createdAt, String updatedAt, Object deletedAt, ArrayList<Items> items) {
        this.id = id;
        this.name = name;
        this.enName = enName;
        this.image = image;
        this.subCat = subCat;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
        this.items = items;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEnName() {
        return enName;
    }

    public String getImage() {
        return image;
    }

    public String getSubCat() {
        return subCat;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public Object getDeletedAt() {
        return deletedAt;
    }

    public ArrayList<Items> getItems() {
        return items;
    }

    public static class Items {
        private final int id;

        private final String discount;

        private final String name;

        private final String enName;

        private final String details;

        private final String enDetails;

        private final String price;

        private final String image;

        private final String categoriesId;

        private final String createdAt;

        private final String updatedAt;

        private final Object deletedAt;

        public Items(int id, String discount, String name, String enName, String details,
                     String enDetails, String price, String image, String categoriesId, String createdAt,
                     String updatedAt, Object deletedAt) {
            this.id = id;
            this.discount = discount;
            this.name = name;
            this.enName = enName;
            this.details = details;
            this.enDetails = enDetails;
            this.price = price;
            this.image = image;
            this.categoriesId = categoriesId;
            this.createdAt = createdAt;
            this.updatedAt = updatedAt;
            this.deletedAt = deletedAt;
        }

        public int getId() {
            return id;
        }

        public String getDiscount() {
            return discount;
        }

        public String getName() {
            return name;
        }

        public String getEnName() {
            return enName;
        }

        public String getDetails() {
            return details;
        }

        public String getEnDetails() {
            return enDetails;
        }

        public String getPrice() {
            return price;
        }

        public String getImage() {
            return image;
        }

        public String getCategoriesId() {
            return categoriesId;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public Object getDeletedAt() {
            return deletedAt;
        }
    }
}
