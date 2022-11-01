package kg.megacom.service;

import kg.megacom.models.Receipt;

import java.util.List;

public interface ReceiptService {
    public void createReceipt(Receipt receipt);
    public List<Receipt> getAllReceipts();
    Receipt getReceiptById(Long id);
    public void deleteReceipt(int id);
    void updateReceipt(int id);
}
