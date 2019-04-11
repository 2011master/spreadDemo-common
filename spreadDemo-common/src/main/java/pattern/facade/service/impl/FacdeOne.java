package pattern.facade.service.impl;

import pattern.facade.service.CipherMachine;
import pattern.facade.service.Facade;
import pattern.facade.service.FileReader;
import pattern.facade.service.FileWriter;

public class FacdeOne implements Facade {

    private FileReader fileReader;
    private CipherMachine cipherMachine;
    private FileWriter fileWriter;

    public FacdeOne() {
        this.fileReader = new Reader();
        this.fileWriter = new Writer();
        this.cipherMachine = new CipherMachineOne();
    }

    @Override
    public void handle(String fileNameSrc,String fileNameDes) {
        String read = fileReader.read(fileNameSrc);
        String encrypt = cipherMachine.encrypt(read);
        fileWriter.write(encrypt,fileNameDes);
    }
}
