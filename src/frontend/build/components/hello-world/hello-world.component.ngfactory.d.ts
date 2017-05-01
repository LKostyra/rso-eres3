import * as import0 from './hello-world.component';
import * as import1 from '@angular/core/src/linker/view';
import * as import3 from '@angular/core/src/linker/view_utils';
import * as import7 from '@angular/core/src/linker/component_factory';
export declare class Wrapper_HelloWorldComponent {
    _eventHandler: Function;
    context: import0.HelloWorldComponent;
    _changed: boolean;
    constructor();
    ngOnDetach(view: import1.AppView<any>, componentView: import1.AppView<any>, el: any): void;
    ngOnDestroy(): void;
    ngDoCheck(view: import1.AppView<any>, el: any, throwOnChange: boolean): boolean;
    checkHost(view: import1.AppView<any>, componentView: import1.AppView<any>, el: any, throwOnChange: boolean): void;
    handleEvent(eventName: string, $event: any): boolean;
    subscribe(view: import1.AppView<any>, _eventHandler: any): void;
}
export declare const HelloWorldComponentNgFactory: import7.ComponentFactory<import0.HelloWorldComponent>;
export declare class View_HelloWorldComponent0 extends import1.AppView<import0.HelloWorldComponent> {
    _el_0: any;
    _text_1: any;
    _text_2: any;
    _el_3: any;
    _text_4: any;
    _expr_5: any;
    constructor(viewUtils: import3.ViewUtils, parentView: import1.AppView<any>, parentIndex: number, parentElement: any);
    createInternal(rootSelector: string): import7.ComponentRef<any>;
    detectChangesInternal(throwOnChange: boolean): void;
}
