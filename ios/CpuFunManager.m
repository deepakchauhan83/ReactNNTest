//
//  CpuFunManager.m
//  ReactNNTest
//
//  Created by Inforcea on 02/11/19.
//  Copyright © 2019 Facebook. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "CpuFunManager.h"
#import <React/RCTLog.h>

@implementation CpuFunManager

RCT_EXPORT_MODULE(CpuFunModule);

RCT_REMAP_METHOD(performCpuFun,
                 calcSumResolver:(RCTPromiseResolveBlock)resolve
                 rejecter:(RCTPromiseRejectBlock)reject)
{
  dispatch_async(dispatch_get_global_queue(DISPATCH_QUEUE_PRIORITY_DEFAULT, 0), ^{
    long sum =0;
       for (int i = 0; i < 1000; i++) {
          for (int j = 0; j < 1000; j++) {
              for (int k = 0; k < 1000; k++) {
                   sum = sum + i + j + k;
              }
           }
       }
    NSString* sumString = [[NSNumber numberWithLong:sum] stringValue];
    resolve(sumString);
  });
}

@end
