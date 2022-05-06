package org.pg4200.ex11;

public class GradeCompressorTest extends GradeCompressorTestTemplate{
    @Override
    protected GradeCompressor getNewInstance() {
        return new GradeCompressorImp();
    }
}
